use std::vec;

struct Solution;
impl Solution {
    pub fn generate_parenthesis_rec(rest: i32, opened: i32, acc: String, result: &mut Vec<String>) {
        if rest == 0 && opened == 0 {
            result.push(acc);
            return;
        }
        if opened > 0 {
            Self::generate_parenthesis_rec(rest, opened - 1, acc.clone() + ")", result)
        }
        if rest > 0 {
            Self::generate_parenthesis_rec(rest - 1, opened + 1, acc.clone() + "(", result)
        }
    }

    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        let mut result: Vec<String> = vec![];
        Self::generate_parenthesis_rec(n, 0, String::new(), &mut result);
        result
    }
}

#[test]
fn test() {
    let expected = vec![
        String::from("((()))"),
        String::from("(()())"),
        String::from("(())()"),
        String::from("()(())"),
        String::from("()()()"),
    ];
    let actual = Solution::generate_parenthesis(3);
    assert!(expected.iter().all(|item| actual.contains(item)));

    let expected = vec![String::from("()")];
    let actual = Solution::generate_parenthesis(1);
    assert!(expected.iter().all(|item| actual.contains(item)));
}
