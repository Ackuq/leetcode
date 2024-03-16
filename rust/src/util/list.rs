#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    pub fn link(val: i32, next: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        Some(Box::new(ListNode { val, next }))
    }
}

#[macro_export]
macro_rules! list_node {
    () => {
        None as Option<Box<ListNode>>
    };
    ($e:expr) => {
        ListNode::link($e, None)
    };
    ($e:expr, $($tail:tt)*) => {
        ListNode::link($e, list_node!($($tail)*))
    };
}

#[cfg(test)]
pub(crate) use list_node;
