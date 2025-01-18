package com.unicorn.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

    List<Integer> stocks;
    List<Integer> spans;

    public StockSpanner() {
        stocks = new
                ArrayList();
        spans = new ArrayList();

    }

    public int next(int price) {

        int count = 1;
        int pos = stocks.size() -1;
        while(pos >=0 && stocks.get(pos) <= price){

            count += spans.get(pos);
            pos = pos - spans.get(pos);

        }
        spans.add(count);
        stocks.add(price);
        return count;

    }
}
