use std::collections::VecDeque;

#[cfg(test)]
use crate::util::list::list_node;
use crate::util::list::ListNode;

struct Solution;
impl Solution {
    fn merge(a: Option<Box<ListNode>>, b: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        if a.is_none() && b.is_none() {
            return None;
        }
        if a.is_none() {
            return b;
        }
        if b.is_none() {
            return a;
        }
        let mut a = a.unwrap();
        let mut b = b.unwrap();
        if a.val < b.val {
            a.next = Self::merge(a.next, Some(b));
            return Some(a);
        }
        b.next = Self::merge(Some(a), b.next);
        return Some(b);
    }

    pub fn merge_k_lists(lists: Vec<Option<Box<ListNode>>>) -> Option<Box<ListNode>> {
        if lists.is_empty() {
            return None;
        }

        let mut queue = VecDeque::from(lists);

        while queue.len() > 1 {
            let a = queue.pop_front().unwrap();
            let b = queue.pop_front().unwrap();
            queue.push_back(Self::merge(a, b));
        }
        return queue.pop_back().unwrap();
    }
}

#[test]
fn test() {
    let lists = vec![list_node!(1, 4, 5), list_node!(1, 3, 4), list_node!(2, 6)];
    let expected = list_node!(1, 1, 2, 3, 4, 4, 5, 6);
    let actual = Solution::merge_k_lists(lists);
    assert_eq!(expected, actual);

    let lists: Vec<Option<Box<ListNode>>> = vec![];
    let actual = Solution::merge_k_lists(lists);
    let expected = None;
    assert_eq!(expected, actual);

    let lists = vec![list_node!()];
    let actual = Solution::merge_k_lists(lists);
    let expected = None;
    assert_eq!(expected, actual);
}
