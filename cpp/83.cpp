#include "./listnode.h"

using namespace std;

class Solution {
 public:
  ListNode* deleteDuplicates(ListNode* head) {
    auto curr = head;
    while (curr != nullptr && curr->next != nullptr) {
      if (curr->val == curr->next->val) {
        curr->next = curr->next->next;
        continue;
      }
      curr = curr->next;
    }

    return head;
  }
};