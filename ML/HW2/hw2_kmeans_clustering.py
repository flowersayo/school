import numpy as np
import matplotlib.pyplot as plt

# 유클리드 거리 계산 함수
def euclidean_distance(a, b):
    return np.sqrt(np.sum((a - b)**2))

# 데이터 파일에서 좌표 읽기
def read_data(file_path):
    data = []
    labels = []

    with open(file_path, 'r') as file:
        for line in file:
            values = line.strip().split(',')
            # 첫 번째 값(클러스터 ID)은 무시하고 두 번째, 세 번째 좌표만 사용
            data.append([float(values[1]), float(values[2])])
            labels.append(int(float(values[0]))) # 초기 클러스터 라벨
    return np.array(data), np.array(labels)

def read_centroid(file_path):
    return np.array(np.loadtxt(file_path, delimiter=',', dtype=float))

# K-means Clustering 클래스
class KMeans:
    def __init__(self,labels, n_clusters, max_iter=300, tol=1e-5, init_centroids=None):
        self.n_clusters = n_clusters  # 클러스터 개수 (K=2)
        self.max_iter = max_iter  # 최대 반복 횟수
        self.tol = tol  # 수렴 기준 (변화율이 이보다 작아지면 중지)
        self.centroids = init_centroids  # 초기 클러스터 중심 [(x1,y1),(x2,y2)]
        self.labels = labels # 각 데이터 포인트가 속하는 클러스터 레이블.


    def fit(self, X):

        # 0 단계 시각화 출력
        self.plot_step(X,0)

        # 초기 중심 설정
        for i in range(self.max_iter):

            # 각 데이터 포인트에 대해 가장 가까운 클러스터 중심을 업데이트
            self.labels = np.array([self.closest_centroid(x) for x in X])
            
            # 이전 중심을 저장 (중심 업데이트 후 비교하기 위해)
            old_centroids = self.centroids.copy()
            
            # 각 클러스터마다 해당 클러스터에 속한 좌표 목록을 평균하여 새로운 중심을 계산
            for k in range(self.n_clusters):
                cluster_points = X[self.labels == k]
                if len(cluster_points) > 0:
                    self.centroids[k] = np.mean(cluster_points, axis=0) # 클러스터 k 의 중심점 좌표 업데이트 

            # 중심이 얼마나 이동했는지 계산
            centroid_shift = np.sum(np.linalg.norm(self.centroids - old_centroids, axis=1))
            
            # 시각화: 각 단계에서의 결과 출력
            self.plot_step(X, i + 1)
            
            # 수렴 여부 확인
            if centroid_shift < self.tol:
                print(f"Converged after {i+1} iterations")
                break
            
    # 특정 데이터 포인트에 대해 가장 가까운 클러스터 중심을 찾음
    def closest_centroid(self, x):
        distances = [euclidean_distance(x, centroid) for centroid in self.centroids]
        return np.argmin(distances) # 가장 거리가 가까운 클러스터의 인덱스 반환 
    
    
    # 각 단계별 클러스터링 결과 시각화
    def plot_step(self, X, step):       
        
        cluster_color_set = ['blue','red']   

        # 각 클러스터 별 그룹 시각화
        for k, centroid in enumerate(self.centroids):
            plt.scatter(centroid[0], centroid[1], c=cluster_color_set[k], marker='x', s=200, label=f'Centroid {k}')
            plt.scatter(X[self.labels == k ][:,0], X[self.labels == k ][:,1], c=cluster_color_set[k])  
        
        plt.title(f"K-means Clustering (Step {step})")
        plt.legend()
        plt.show()



def main():
    # 데이터 파일 로드
    data_file = './data/hw2_data_2d.csv'
    centroids_file = './data/hw2_2d_init_centroids.csv'
    
    X, labels = read_data(data_file)  # 데이터 포인트 로드
    init_centroids = read_centroid(centroids_file)  # 초기 중심 로드

    # K-means 클러스터링
    kmeans = KMeans(labels=labels ,n_clusters=2, init_centroids=init_centroids)
    kmeans.fit(X)

if __name__ == '__main__':
    main()
