package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class __12891 {

  private static int[] checking;
  private static int[] currentStatusArr;
  private static int satisfiedNum;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int s = Integer.parseInt(stringTokenizer.nextToken());
    int p = Integer.parseInt(stringTokenizer.nextToken());
    int result = 0;
    checking = new int[4];
    currentStatusArr = new int[4];
    char[] a;
    //4개가 되면 만족!
    satisfiedNum = 0;

    a = bufferedReader.readLine()
                      .toCharArray();
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < 4; i++) {
      checking[i] = Integer.parseInt(stringTokenizer.nextToken());
      if (checking[i] == 0) { //0개 이상이라는건 어떤 상황에도 그 기호는 이미 만족했다는 거니까
        satisfiedNum++;
      }
    }
    for (int i = 0; i < p; i++) { //부분 문자열 처음 받을 때 세팅
      add(a[i]);
    }
    if (satisfiedNum == 4) {
      result++;
    }
    //슬라이딩 윈도우
    for (int i = p; i < s; i++) {
      int j = i - p;
      add(a[i]);
      remove(a[j]);
      if (satisfiedNum == 4) {
        result++;
      }
    }
    System.out.println(result);
    bufferedReader.close();

  }

  private static void remove(char c) {
    switch (c) {
      case ('A'): {
        currentStatusArr[0]--;
        if (currentStatusArr[0] == checking[0]) {
          satisfiedNum--;
        }
      }
      case ('C'): {
        currentStatusArr[1]--;
        if (currentStatusArr[1] == checking[1]) {
          satisfiedNum--;
        }
      }
      case ('G'): {
        currentStatusArr[2]--;
        if (currentStatusArr[2] == checking[2]) {
          satisfiedNum--;
        }
      }
      case ('T'): {
        currentStatusArr[3]--;
        if (currentStatusArr[3] == checking[3]) {
          satisfiedNum--;
        }
      }
    }
  }

  private static void add(char c) {
    switch (c) {
      case ('A'): {
        currentStatusArr[0]++;
        if (currentStatusArr[0] == checking[0]) {
          satisfiedNum++;
        }
      }
      case ('C'): {
        currentStatusArr[1]++;
        if (currentStatusArr[1] == checking[1]) {
          satisfiedNum++;
        }
      }
      case ('G'): {
        currentStatusArr[2]++;
        if (currentStatusArr[2] == checking[2]) {
          satisfiedNum++;
        }
      }
      case ('T'): {
        currentStatusArr[3]++;
        if (currentStatusArr[3] == checking[3]) {
          satisfiedNum++;
        }
      }
    }
  }
}
