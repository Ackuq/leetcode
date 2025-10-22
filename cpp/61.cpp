#include "listnode.h"

class Solution {
 public:
  ListNode* rotateRight(ListNode* head, int k) {
    // We just need to find out which node is gonna be at the end and start and
    // make the start = head and end->next = nullptr,
    if (head == nullptr || head->next == nullptr) return head;
    int size = 1;
    auto initialEnd = head;
    while (initialEnd->next != nullptr) {
      initialEnd = initialEnd->next;
      size++;
    }
    // Make circular for now
    initialEnd->next = head;

    int rotations = k % size;
    auto newTail = head;
    int newTailPosition = size - rotations;
    while (newTailPosition >= 0) {
      newTail = newTail->next;
      newTailPosition--;
    }
    auto newHead = newTail->next;
    newTail->next = nullptr;

    return newHead;
  }
};