#[cfg(test)]
use crate::util::list::list_node;
use crate::util::list::ListNode;

struct Solution;
impl Solution {
    pub fn merge_two_lists(
        list1: Option<Box<ListNode>>,
        list2: Option<Box<ListNode>>,
    ) -> Option<Box<ListNode>> {
        if list1.is_none() {
            return list2;
        }
        if list2.is_none() {
            return list1;
        }
        let mut node1 = list1.unwrap();
        let mut node2 = list2.unwrap();
        if node1.val < node2.val {
            node1.next = Self::merge_two_lists(node1.next, Some(node2));
            return Some(node1);
        }
        node2.next = Self::merge_two_lists(Some(node1), node2.next);
        Some(node2)
    }
}

#[test]
fn test() {
    let list1 = list_node!(1, 2, 4);
    let list2 = list_node!(1, 3, 4);
    let expected = list_node!(1, 1, 2, 3, 4, 4);
    let actual = Solution::merge_two_lists(list1, list2);
    assert_eq!(actual, expected)
}
