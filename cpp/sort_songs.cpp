#include <iostream>
#include <map>
#include <vector>

using namespace std;

struct Song {
  string name;
  int streams;
};

bool sortSongs(Song& s1, Song& s2) {
  if (s1.streams == s2.streams) {
    return lexicographical_compare(s1.name.begin(), s1.name.end(),
                                   s2.name.begin(), s2.name.end());
  }
  return s1.streams > s2.streams;
}

class TopSongs {
 public:
  vector<Song> topSongs(vector<Song>& user1, vector<Song>& user2, int n) {
    map<string, int> counter;
    auto users = {user1, user2};

    for (auto& user : users) {
      for (auto& s : user) {
        if (counter.find(s.name) == counter.end()) {
          counter[s.name] = s.streams;
          continue;
        }
        counter[s.name] += s.streams;
      }
    }
    vector<Song> result;
    for (auto& s : counter) {
      result.push_back(Song{s.first, s.second});
    }

    sort(result.begin(), result.end(), sortSongs);
    result.resize(n);

    return result;
  }
};

int main() {
  TopSongs solution;

  vector<Song> user1 = {Song{"d", 2}};
  vector<Song> user2 = {Song{"a", 2}};

  auto topSongs = solution.topSongs(user1, user2, 2);

  for (auto s : topSongs) {
    cout << s.name << "-" << s.streams << endl;
  }
}