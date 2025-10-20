

#include <stdlib.h>

#include "./listnode.cpp"

class Solution {
 public:
  ListNode* reverseBetween(ListNode* head, int left, int right) {
    if (left == right) return head;

    ListNode dummy;
    dummy.next = head;
    auto beforeLeft = &dummy;

    for (int i = 1; i < left; i++) {
      beforeLeft = beforeLeft->next;
    }

    auto leftNode = beforeLeft->next;

    ListNode* prev = nullptr;
    auto curr = beforeLeft->next;

    for (int i = 0; i <= right - left; i++) {
      auto next = curr->next;
      curr->next = prev;
      prev = curr;
      curr = next;
    }

    beforeLeft->next = prev;
    leftNode->next = curr;

    return dummy.next;
  }
};

int main() {
  ListNode node5(5);
  ListNode node4(4, &node5);
  ListNode node3(3, &node4);
  ListNode node2(2, &node3);
  ListNode head(1, &node2);
  Solution s;

  s.reverseBetween(&head, 2, 4);

  auto curr = head;
  head = ListNode(5);

  s.reverseBetween(&head, 1, 1);

  return 0;
}