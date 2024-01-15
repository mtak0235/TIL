package com.example.tobby.templateCallback;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

  public Integer calcSum(String filepath) throws IOException {
    LineCallback<Integer> sumCallback = new LineCallback<Integer>() {

      @Override
      public Integer doSomethingWithLine(String line, Integer value) {
        return value + Integer.valueOf(line);
      }
    };
    return lineReadTemplate(filepath, sumCallback, 0);
  }

  public Integer calcMultiply(String filepath) throws IOException {
    LineCallback<Integer> sumCallback = new LineCallback<Integer>() {

      @Override
      public Integer doSomethingWithLine(String line, Integer value) {
        return value * Integer.valueOf(line);
      }
    };
    return lineReadTemplate(filepath, sumCallback, 1);
  }

  public String concatenate(String filepath) {
    LineCallback<String> concatenateCallback = new LineCallback<String>() {
      @Override
      public String doSomethingWithLine(String line, String value) {
        return value + line;
      }
    };
    return lineReadTemplate(filepath, concatenateCallback, "");
  }

  public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback)
      throws IOException {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(filepath));
      int ret = callback.doSomethingWithReader(br);
      return ret;
    } catch (IOException e) {
      System.out.println("e.getMessage() = " + e.getMessage());
      throw e;
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          System.out.println("e.getMessage() = " + e.getMessage());
        }
      }
    }
  }

  public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initValue) {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(filepath));
      T ret = initValue;
      String line = null;
      while ((line = br.readLine()) != null) {
        ret = callback.doSomethingWithLine(line, ret);
      }
      return ret;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {

    }
  }
}
