import sys
assert sys.version_info >= (3, 7)

from packaging import version
import sklearn

assert version.parse(sklearn.__version__) >= version.parse("1.0.1")

import matplotlib.pyplot as plt
import numpy as np
from sklearn.svm import SVC
from sklearn.preprocessing import StandardScaler
from sklearn.pipeline import make_pipeline
from sklearn.naive_bayes import MultinomialNB
from sklearn.model_selection import GridSearchCV

def svm_readMatrix(file):
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
    category = (np.array(Y) * 2) - 1
    return matrix, tokens, category


def svm_test(svm, matrix):
    M, N = matrix.shape
    output = np.zeros(M)
    output = svm.predict(matrix)

    return output

def evaluate(output, label):
    error = (output != label).sum() * 1. / len(output)
    #print('Error: %1.4f'%error)
    return error

# SVM 모델 최적의 파라미터 찾기 - 그리드 서치 (grid search)
def grid_search(svm_model,trainMatrix, trainCategory):
    param_grid = {
        'C': [0.1, 1, 10, 100],          # C의 값 후보들
        'gamma': [1, 0.1, 0.01, 0.001],  # gamma의 값 후보들
    }
    
    # 그리드 서치 설정 (교차 검증을 5번 수행)
    grid_search = GridSearchCV(svm_model, param_grid, cv=5, scoring='accuracy')

    # 데이터 로드 (trainMatrix, trainCategory) - 이미 존재하는 데이터 사용

    # 그리드 서치 실행 (훈련 데이터에 대해 최적 파라미터를 찾음)
    grid_search.fit(trainMatrix, trainCategory)

    # 최적의 파라미터와 그에 따른 성능 확인
    print(f"Best parameters: {grid_search.best_params_}")
    print(f"Best cross-validation accuracy: {grid_search.best_score_:.4f}")

    return 



def plotLearningCurve(train_sizes, test_errors):

    plt.plot(train_sizes, test_errors, marker='o', color='b')
    plt.title('Learning Curve (Training Set Size vs Test Error)')
    plt.xlabel('Training Set Size')
    plt.ylabel('Test Error')
    plt.grid(True)
    plt.show()


def main():
    # Please set a training file that you want to use for this run below
    trainMatrix, tokenlist, trainCategory = svm_readMatrix('./data/hw2_MATRIX.TRAIN.400')
    testMatrix, tokenlist, testCategory = svm_readMatrix('./data/hw2_MATRIX.TEST')

    # SVM Classifier model
    # Find out the best parameters of C, max_iter, and so on

    # Hard margin SVM
    svm_clf_hard = SVC(kernel="linear", C=float("inf"), max_iter=10_000, random_state=42)      

    # Soft margin SVM
    svm_clf_soft = SVC(kernel="linear",gamma=1, C=0.1, max_iter=10_000, random_state=42)
    grid_search(svm_clf_soft,trainMatrix, trainCategory)  # {'svc__C': 0.1, 'svc__gamma': 1}
    
    # Gaussian RBF SVM
    svm_clf_rbf = SVC(kernel="rbf", gamma=0.001, C=10, max_iter=10_000, random_state=42)
    grid_search(svm_clf_rbf,trainMatrix, trainCategory) # {'svc__C': 10, 'svc__gamma': 0.001}

    # Naive Bayes Classifier
    nb_clf = MultinomialNB()
    scaler = StandardScaler()

    # Scaled version for each SVM and we will use these
    scaled_svm_clf_hard = make_pipeline(scaler, svm_clf_hard)
    scaled_svm_clf_soft = make_pipeline(scaler, svm_clf_soft)
    scaled_svm_clf_rbf = make_pipeline(scaler, svm_clf_rbf)

    
    # scaled 된 이후의 파이프라인 모델에 대해서도 그리드 서치를 적용해보았지만 동일한 결과가 나왔다.
    # grid_search(scaled_svm_clf_soft,trainMatrix, trainCategory) # {'svc__C': 0.1, 'svc__gamma': 1}
    # grid_search(scaled_svm_clf_rbf,trainMatrix, trainCategory) # {'svc__C': 10, 'svc__gamma': 0.001}

    
    # Train an SVM by forming suitable X and y
    # e.g., scaled_svm_clf_hard.fit(X, y) 
    # Refer to the above code for other SVMs

    scaled_svm_clf_hard.fit(trainMatrix, trainCategory)
    scaled_svm_clf_soft.fit(trainMatrix, trainCategory)
    scaled_svm_clf_rbf.fit(trainMatrix, trainCategory)
    nb_clf.fit(trainMatrix, trainCategory)


    output_hard = svm_test(scaled_svm_clf_hard, testMatrix)
    output_soft = svm_test(scaled_svm_clf_soft, testMatrix)
    output_rbf = svm_test(scaled_svm_clf_rbf, testMatrix)
    output_nb = nb_clf.predict(testMatrix)


    print("\n== compare SVM implementations  ==\n")
   
    error_hard = evaluate(output_hard, testCategory)
    print("Hard margin SVM Error: %1.4f" % error_hard )
    
    error_soft = evaluate(output_soft, testCategory)
    print("Soft margin SVM Error: %1.4f" % error_soft )

    
    error_rbf = evaluate(output_rbf, testCategory)
    print("Gaussian RBF SVM Error: %1.4f" % error_rbf)
    print("\n=================================\n")


    # 훈련 세트 크기별로 파일을 읽고 학습 후 오류율 계산
    training_set_size = [50, 100, 200, 400, 800, 1400]
    errors_hard = []
    errors_soft = []
    errors_rbf = []
    errors_nb = []

    for size in training_set_size:
        trainMatrix, tokenlist, trainCategory = svm_readMatrix(f'./data/hw2_MATRIX.TRAIN.{size}')

        # SVM 모델 학습
        scaled_svm_clf_hard.fit(trainMatrix, trainCategory)
        scaled_svm_clf_soft.fit(trainMatrix, trainCategory)
        scaled_svm_clf_rbf.fit(trainMatrix, trainCategory)

        output_hard = svm_test(scaled_svm_clf_hard, testMatrix)
        output_soft = svm_test(scaled_svm_clf_soft, testMatrix)
        output_rbf = svm_test(scaled_svm_clf_rbf, testMatrix)
   
        error_hard = evaluate(output_hard, testCategory)
        error_soft = evaluate(output_soft, testCategory)
        error_rbf = evaluate(output_rbf, testCategory)
        error_nb = evaluate(output_nb, testCategory)

        errors_hard.append(error_hard)
        errors_soft.append(error_soft)
        errors_rbf.append(error_rbf)
        errors_nb.append(error_nb)

        # 각 훈련 세트 크기에서 오류율 출력
        print(f"Training Size: {size}, Hard SVM Error: {error_hard:.4f}, Soft SVM Error: {error_soft:.4f}, RBF SVM Error: {error_rbf:.4f}, Naive Bayes Error: {error_nb:.4f}")


    # 그래프 그리기
    plt.figure(figsize=(10, 6))
    plt.plot(training_set_size, errors_hard, label='Hard SVM', marker='o')
    plt.plot(training_set_size, errors_soft, label='Soft SVM', marker='o')
    plt.plot(training_set_size, errors_rbf, label='RBF SVM', marker='o')
    plt.plot(training_set_size, errors_nb, label='Naive Bayes', marker='o')


    # 그래프 설정
    plt.title('Test Error vs Training Set Size for SVM and Naive Bayes')
    plt.xlabel('Training Set Size')
    plt.ylabel('Test Error')
    plt.legend()
    plt.grid(True)
    plt.show()


    return

if __name__ == '__main__':
    main()
