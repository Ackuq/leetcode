#include <queue>
using namespace std;

class MedianFinder {
 public:
  MedianFinder() {}

  void addNum(int num) {
    max_heap.push(num);
    min_heap.push(max_heap.top());
    max_heap.pop();

    if (max_heap.size() < min_heap.size()) {
      max_heap.push(min_heap.top());
      min_heap.pop();
    }
  }

  double findMedian() {
    if (max_heap.size() > min_heap.size()) {
      return max_heap.top();
    }
    return (max_heap.top() + min_heap.top()) / 2.0;
  }

 private:
  priority_queue<int, vector<int>, less<int>> max_heap;
  priority_queue<int, vector<int>, greater<int>> min_heap;
};

int main() {
  MedianFinder mf;

  for (int i = 1; i < 20; i++) {
    mf.addNum(i);
  }

  return 0;
}
