#include <vector>

using namespace std;

class Solution {
 public:
  void sortColors(vector<int>& nums) { quickSort(nums, 0, nums.size() - 1); }

 private:
  int partition(vector<int>& arr, int low, int high) {
    auto pivot = arr[high];
    auto i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        swap(arr[++i], arr[j]);
      }
    }
    swap(arr[i + 1], arr[high]);
    return i + 1;
  }

  void quickSort(vector<int>& arr, int low, int high) {
    if (low < high) {
      auto pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }
};