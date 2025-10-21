#include <algorithm>
#include <map>
#include <sstream>
#include <unordered_map>
#include <vector>

using namespace std;

class FileSystem {
 public:
  FileSystem() { root = new Directory(); }

  vector<string> ls(string path) {
    auto current = root;
    if (path != "/") {
      auto directory = path.substr(1, path.find_last_of('/'));
      auto fileName = path.substr(path.find_last_of('/') + 1);
      stringstream ss(directory);
      string name;
      while (getline(ss, name, '/')) {
        current = current->folders[name];
      }
      if (current->files.contains(fileName)) {
        return vector{fileName};
      }
      current = current->folders[fileName];
    }
    vector<string> result;
    for (auto file : current->files) {
      result.push_back(file.first);
    }
    for (auto folder : current->folders) {
      result.push_back(folder.first);
    }
    sort(result.begin(), result.end());
    return result;
  }

  void mkdir(string path) {
    auto current = root;
    stringstream ss(path.substr(1));
    string name;
    while (getline(ss, name, '/')) {
      if (!current->folders.contains(name)) {
        current->folders[name] = new Directory();
      }
      current = current->folders[name];
    }
  }

  void addContentToFile(string filePath, string content) {
    auto directory = filePath.substr(1, filePath.find_last_of('/'));
    auto fileName = filePath.substr(filePath.find_last_of('/') + 1);

    auto current = root;
    stringstream ss(directory);
    string name;
    while (getline(ss, name, '/')) {
      current = current->folders[name];
    }

    current->files[fileName] += content;
  }

  string readContentFromFile(string filePath) {
    auto directory = filePath.substr(1, filePath.find_last_of('/'));
    auto fileName = filePath.substr(filePath.find_last_of('/') + 1);

    auto current = root;
    stringstream ss(directory);
    string name;
    while (getline(ss, name, '/')) {
      current = current->folders[name];
    }

    return current->files[fileName];
  }

 private:
  class Directory {
   public:
    unordered_map<string, string> files;
    unordered_map<string, Directory*> folders;
  };
  Directory* root;
};

int main() {
  auto fileSystem = new FileSystem();
  //"mkdir","ls","ls","addContentToFile","ls","ls","ls"]
  //,["/z"],["/"],["/"],["/goowmfn/c","shetopcy"],["/z"],["/goowmfn/c"],["/goowmfn"]]
  fileSystem->mkdir("/goowmfn");  // return []
  fileSystem->ls("/goowmfn");
  fileSystem->ls("/");
  fileSystem->mkdir("/z");
  fileSystem->readContentFromFile("/a/b/c/d");  // return "hello"
}