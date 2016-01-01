package com.beans;

import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 01.01.2016.
 */
public class SortFilterModel<E> extends DataModel<E> {
    private DataModel<E> model;
    private Integer[] rows;
    public List getRows(){
        return new ArrayList<Integer>(Arrays.asList(rows));
    }
    public SortFilterModel(){
        setWrappedData(null);
    }
    public SortFilterModel(E[] names){
        setWrappedData(names);
    }
    public SortFilterModel(ListDataModel<E> model){
        System.out.println("#####Конструктор sortfiltredModel model="+model);
        this.model = model;
        initializeRows();
    }
    public SortFilterModel(DataModel<E> model){
        this.model = model;
    }
    private E getData(int row){
        int originalIndex = model.getRowIndex();
        model.setRowIndex(row);
        E thisRowDate = model.getRowData();
        model.setRowIndex(originalIndex);
        return thisRowDate;
    }
    public void sortBy(final Comparator<E> dataComparator){
        Comparator<Integer> rowComparator = new
                Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        E e1 = getData(o1);
                        E e2 = getData(o2);
                        return dataComparator.compare(e1, e2);
                    }
                };
        Arrays.sort(rows, rowComparator);
    }
    @Override
    public boolean isRowAvailable() {
        return model.isRowAvailable();
    }

    @Override
    public int getRowCount() {
        return model.getRowCount();
    }

    @Override
    public E getRowData() {
        return model.getRowData();
    }

    @Override
    public int getRowIndex() {
        return model.getRowIndex();
    }

    @Override
    public void setRowIndex(int i) {
        if (0 <= i && i < rows.length){
            model.setRowIndex(rows[i]);
        }else{
            model.setRowIndex(i);
        }
    }

    @Override
    public Object getWrappedData() {
        return model.getWrappedData();
    }

    @Override
    public void setWrappedData(Object o) {
        model.setWrappedData(o);
        initializeRows();
    }
    private void initializeRows(){
        int rowCount = model.getRowCount();
        if (rowCount != -1){
            rows = new Integer[rowCount];
            for (int i = 0; i < rowCount; i++) rows[i] = i;
        }
    }
}
