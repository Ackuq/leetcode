#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

type ListLink = Option<Box<ListNode>>;

impl ListNode {
    #[inline]
    pub fn new(val: i32) -> ListLink {
        Some(Box::new(ListNode { val, next: None }))
    }

    #[inline]
    pub fn link(val: i32, next: ListLink) -> ListLink {
        Some(Box::new(ListNode { val, next }))
    }
}
