#include <string>

#include "./listnode.cpp"

using namespace std;

class Solution {
 public:
  ListNode* partition(ListNode* head, int x) {
    auto left_head = new ListNode(0);
    auto left_curr = left_head;
    auto right_head = new ListNode(0);
    auto right_curr = right_head;

    auto curr = head;
    while (curr != nullptr) {
      if (curr->val < x) {
        left_curr->next = curr;
        left_curr = left_curr->next;
      } else {
        right_curr->next = curr;
        right_curr = right_curr->next;
      }
      curr = curr->next;
    }
    right_curr->next = nullptr;
    left_curr->next = right_head->next;
    return left_head->next;
  }
};

int main(int argc, char const* argv[]) { return 0; }
