struct Solution;
impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        if nums.len() == 0 {
            return 0;
        }
        let mut last = nums[0];
        let mut unique = 1;
        for i in 1..nums.len() {
            if nums[i] != last {
                last = nums[i];
                nums[unique] = nums[i];
                unique += 1;
            }
        }
        nums.resize(unique, 0);
        nums.shrink_to_fit();
        unique as i32
    }
}

#[test]
fn test() {
    let mut nums = vec![1, 1, 2];
    let expected = 2;
    let actual = Solution::remove_duplicates(&mut nums);
    assert_eq!(expected, actual);

    let mut nums = vec![0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
    let expected = 5;
    let actual = Solution::remove_duplicates(&mut nums);
    assert_eq!(expected, actual);
}
