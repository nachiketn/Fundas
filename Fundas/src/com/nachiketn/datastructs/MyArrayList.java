package com.nachiketn.datastructs;

import java.util.Arrays;

public class MyArrayList<E> {

	private static final int DEFAULT_SIZE = 10;
	private int size;
	private Object[] elements;
	
	public MyArrayList() {
		elements = new Object[DEFAULT_SIZE];
	}
	
	public MyArrayList(final int initCapacity) {
		elements = new Object[initCapacity];
	}
	
	public void add(final E e) {
		if(size==elements.length) {
			ensureCapacity((int)(1.5*elements.length));
		}
		elements[size++] = e;
	}
	
	public void add(final int index, final E element) throws ArrayIndexOutOfBoundsException {
		if (index > elements.length || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if (index < size) {
			if(size==elements.length) {
				ensureCapacity((int)(1.5*elements.length));
			}
			System.arraycopy(elements, index, elements, index+1, size-index);
			elements[index]= element;
			size++;
		}
		else if (index > size) {
			elements[size++] = element;
		}
	}
	
	public void ensureCapacity(final int minCapacity) {
		/*Object[] newArray = new Object[minCapacity];
		for (int i = 0 ; i < size ; i++ )
			newArray[i] = elements[i];
		elements = newArray;*/
		elements = Arrays.copyOf(elements, minCapacity); 
	}
	
	public E get(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException();
		return (E)elements[index];
	}
	
	public void remove(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException();
		size--;
		System.arraycopy(elements, index+1, elements, index, size-index);
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		for (int i = 0 ; i < size ; i++) {
			buff.append(elements[i]+" ");
		}
		return buff.toString();
	}
	
	public static void main(String[] args){
		MyArrayList<Integer> arr = new MyArrayList<>(2);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(2,1);
		System.out.println(arr);
		arr.remove(2);
		System.out.println(arr);
		arr.add(2, 5);
		System.out.println(arr);
		System.out.println(arr.get(2));
	}
}
