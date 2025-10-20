#include <algorithm>
#include <iostream>
#include <random>
#include <vector>

using namespace std;

class TopSongs {
 public:
  TopSongs(vector<string> playlist) {
    this->playlist = playlist;
    random_device rd;
    mt19937 rng(rd());
    this->rng = rng;
  }

  string nextSong() {
    if (queue.size() == 0) {
      shuffleQueue();
    }
    auto song = queue.back();
    queue.pop_back();
    return song;
  }

 private:
  mt19937 rng;
  vector<string> playlist;
  vector<string> queue;
  void shuffleQueue() {
    queue.resize(playlist.size());
    copy(playlist.begin(), playlist.end(), queue.begin());
    shuffle(queue.begin(), queue.end(), rng);
  }
};

int main() {
  vector<string> songs = {"a", "b", "c"};
  TopSongs sp(songs);

  for (int i = 0; i < 10; i++) {
    cout << sp.nextSong() << endl;
  }
}