#[cfg(test)]
use crate::util::list::list_node;
use crate::util::list::ListNode;

struct Solution;
impl Solution {
    pub fn swap_pairs(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        if let Some(mut h) = head {
            if let Some(mut next) = h.next {
                h.next = Self::swap_pairs(next.next);
                next.next = Some(h);
                return Some(next);
            }
            return Some(h);
        }
        return None;
    }
}

#[test]
fn test() {
    let head = list_node!(1, 2, 3, 4);
    let actual = Solution::swap_pairs(head);
    let expected = list_node!(2, 1, 4, 3);
    assert_eq!(expected, actual);

    let head = list_node!();
    let actual = Solution::swap_pairs(head);
    let expected = None;
    assert_eq!(expected, actual);

    let head = list_node!(1);
    let actual = Solution::swap_pairs(head);
    let expected = list_node!(1);
    assert_eq!(expected, actual);
}
