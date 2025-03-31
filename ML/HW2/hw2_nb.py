import matplotlib.pyplot as plt
import numpy as np


TOKEN_LIST_SIZE = 1448

def readMatrix(file):
    fd = open(file, 'r')
    hdr = fd.readline()
    rows, cols = [int(s) for s in fd.readline().strip().split()]
    tokens = fd.readline().strip().split()
    matrix = np.zeros((rows, cols))
    Y = []
    for i, line in enumerate(fd):
        nums = [int(x) for x in line.strip().split()]
        Y.append(nums[0])
        kv = np.array(nums[1:])
        k = np.cumsum(kv[:-1:2])
        v = kv[1::2]
        matrix[i, k] = v
    return matrix, tokens, np.array(Y)

def readTokenlist(file):
    fd = open(file,'r')
    tokens = ['' for i in range(TOKEN_LIST_SIZE+1)]

    for i, line in enumerate(fd):
        idx, token = line.strip().split()
        tokens[int(idx)] = token

    return tokens
    

def nb_train(matrix, category):
    state = {}
    N = matrix.shape[1]  # 전체 특성(토큰)의 개수
  

    # 각 클래스에 속하는 문서 수
    spam_count = np.sum(category)  # 스팸 문서 수 (레이블이 1인 경우)
    not_spam_count = len(category) - spam_count  # 스팸이 아닌 문서 수 (레이블이 0인 경우)

    # 사전 확률 P(spam) 및 P(not_spam)
    P_spam = spam_count / len(category)
    P_not_spam = not_spam_count / len(category)

    # 스팸과 비스팸 문서에서 토큰이 등장한 횟수를 구함
    token_counts_spam = np.sum(matrix[category == 1], axis=0)   # 스팸 문서에서 각 토큰이 등장한 횟수 
    token_counts_not_spam = np.sum(matrix[category == 0], axis=0)  # 비스팸 문서에서 각 토큰이 등장한 횟수

    # 라플라스 스무딩을 적용하여 조건부 확률 P(token|spam) 및 P(token|not_spam) 구하기 
    P_token_given_spam = ( token_counts_spam + 1 ) / ( spam_count + N )
    P_token_given_not_spam = ( token_counts_not_spam + 1 ) / ( not_spam_count + N )

    # 학습된 상태를 저장
    state['P_spam'] = P_spam
    state['P_not_spam'] = P_not_spam
    state['P_token_given_spam'] = P_token_given_spam
    state['P_token_given_not_spam'] = P_token_given_not_spam

    return state

def nb_test(matrix, state):
    output = np.zeros(matrix.shape[0])  # 예측 결과 저장

    # 사전 확률과 조건부 확률 불러오기
    P_spam = state['P_spam']
    P_not_spam = state['P_not_spam']
    P_token_given_spam = state['P_token_given_spam']
    P_token_given_not_spam = state['P_token_given_not_spam']

    # 각 문서에 대해 스팸 여부를 예측
    for i in range(matrix.shape[0]):
        # 각 문서의 토큰 빈도
        doc = matrix[i]

        # 로그 확률을 계산하여 언더플로우 방지
        log_prob_spam = np.log(P_spam) + np.sum(np.log(P_token_given_spam) * doc)
        log_prob_not_spam = np.log(P_not_spam) + np.sum(np.log(P_token_given_not_spam) * doc)

        # 더 높은 로그 확률을 가진 클래스로 예측
        if log_prob_spam > log_prob_not_spam:
            output[i] = 1  # 스팸으로 분류
        else:
            output[i] = 0  # 스팸이 아닌 것으로 분류

    return output

def evaluate(output, label):
    error = (output != label).sum() * 1. / len(output)
    print('Error: %1.4f'%error)

    return error

# Spam 과 Not Spam 을 구분하는 상위 n개의 토큰 찾기
def findTopToken(top_n,state,tokens):

    P_token_given_spam = state['P_token_given_spam']
    P_token_given_not_spam = state['P_token_given_not_spam']

    # 각 토큰에 대한 로그 우도비(log-likelihood ratio)를 계산
    log_likelihood_ratio = np.log(P_token_given_spam) - np.log(P_token_given_not_spam)

    # 로그 우도비가 가장 큰 상위 top_n개의 토큰을 찾음
    top_token_indices = np.argsort(log_likelihood_ratio)[-top_n:][::-1]

     # 상위 top_n개의 토큰과 그 값을 출력
    print(f"\n== Top {top_n} tokens most indicative of SPAM ==\n")
    for idx in top_token_indices:
        print(f"Token: {tokens[idx]}, Log-Odds Ratio: {log_likelihood_ratio[idx]:.4f}")
    print(f"\n==========================================\n")

def plotLearningCurve(train_sizes, test_errors):

    plt.plot(train_sizes, test_errors, marker='o', color='b')
    plt.title('Learning Curve (Training Set Size vs Test Error)')
    plt.xlabel('Training Set Size')
    plt.ylabel('Test Error')
    plt.grid(True)
    plt.show()
    

def main():

    # Please set a training file that you want to use for this run below
    trainMatrix, tokenlist, trainCategory = readMatrix('./data/hw2_MATRIX.TRAIN')
    testMatrix, tokenlist, testCategory = readMatrix('./data/hw2_MATRIX.TEST')
    tokens = readTokenlist('./data/hw2_TOKENS_LIST.txt')

    state = nb_train(trainMatrix, trainCategory)
    output = nb_test(testMatrix, state)

    evaluate(output, testCategory)
    findTopToken(5, state, tokens)


    # 훈련 세트 크기별로 파일을 읽고 학습 후 오류율 계산
    training_set_size = [50, 100, 200, 400, 800, 1400]
    test_errors = []
    for size in training_set_size:
        trainMatrix, tokenlist, trainCategory = readMatrix(f'./data/hw2_MATRIX.TRAIN.{size}')
        state = nb_train(trainMatrix, trainCategory)
        output = nb_test(testMatrix, state)
        error = evaluate(output, testCategory)
        test_errors.append(error)

    # 학습 곡선 그리기
    plotLearningCurve(training_set_size, test_errors)

 
    return

if __name__ == '__main__':
    main()
