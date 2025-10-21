
#include <queue>
#include <unordered_map>

#include "./treenode.cpp"

using namespace std;

class Solution {
 public:
  vector<int> topKFrequent(vector<int>& nums, int k) {
    unordered_map<int, int> frequency;

    for (auto num : nums) {
      if (!frequency.contains(num)) {
        frequency[num] = 1;
      }
      frequency[num]++;
    }

    auto comp = [&frequency](int n1, int n2) {
      return frequency[n1] > frequency[n2];
    };

    priority_queue<int, vector<int>, decltype(comp)> pq(comp);
    for (auto freq : frequency) {
      pq.push(freq.first);
      if (pq.size() > k) {
        pq.pop();
      }
    }

    vector<int> result(k);
    for (int i = 0; i < k; i++) {
      result[i] = pq.top();
      pq.pop();
    }

    return result;
  }
};