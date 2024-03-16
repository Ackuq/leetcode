use std::collections::VecDeque;

#[cfg(test)]
use crate::util::list::list_node;
use crate::util::list::ListNode;

struct Solution;
impl Solution {
    pub fn reverse_k_group(head: Option<Box<ListNode>>, k: i32) -> Option<Box<ListNode>> {
        let mut current = head;
        let mut queue: VecDeque<Option<Box<ListNode>>> = VecDeque::new();
        // Build the queue
        for _ in 0..k {
            if let Some(mut node) = current {
                current = node.next.take();
                queue.push_back(Some(node));
            }
        }
        let mut next: Option<Box<ListNode>>;
        if queue.len() == k as usize {
            next = Self::reverse_k_group(current, k);
            while let Some(Some(mut node)) = queue.pop_front() {
                node.next = next;
                next = Some(node);
            }
        } else {
            // End of the list, just rebuild it
            next = None;
            while let Some(Some(mut node)) = queue.pop_back() {
                node.next = next;
                next = Some(node);
            }
        }
        return next;
    }
}

#[test]
fn test() {
    let head = list_node!(1, 2, 3, 4, 5);
    let k = 2;
    let actual = Solution::reverse_k_group(head, k);
    let expected = list_node!(2, 1, 4, 3, 5);
    assert_eq!(expected, actual);

    let head = list_node!(1, 2, 3, 4, 5);
    let k = 3;
    let actual = Solution::reverse_k_group(head, k);
    let expected = list_node!(3, 2, 1, 4, 5);
    assert_eq!(expected, actual);
}
