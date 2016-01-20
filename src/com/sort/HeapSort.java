package com.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 32, 34, 66, 2, 12, 43, 54, 7, 8, 66, 87, 34, 78 };
		Big_Heap big_heap = new Big_Heap(arr);
		big_heap.heapSort();
		System.out.println(Arrays.toString(big_heap.array));

		Small_Heap small_Heap = new Small_Heap(arr);
		small_Heap.heapSort();
		System.out.println(Arrays.toString(small_Heap.array));

		Small_Heap_2 small_Heap_2 = new Small_Heap_2();
		for (int i : arr) {
			small_Heap_2.insert(i);
		}
		while (!small_Heap_2.empty())
			System.out.println("--> " + small_Heap_2.dele_smallest());
	}

}

class Big_Heap {
	int[] array;

	// 传入一个数组，构造一个大根堆
	public Big_Heap(int[] array) {
		if (array == null || array.length <= 1) {
			System.out.println("data unaviliable !");
		}
		this.array = array;

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(this.array, this.array.length, i);
		}
	}

	// 大根堆的排序
	void heapSort() {
		int swap;
		for (int i = this.array.length - 1; i >= 1; i--) {
			swap = array[0]; // 最大值
			array[0] = array[i];
			array[i] = swap;

			maxHeap(array, i, 0); // 重构大根堆
		}
	}

	// heapsize 为堆的长度
	// index 为调整的开始位置
	void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		int swap;
		if (index != largest) {
			swap = array[index];
			array[index] = array[largest];
			array[largest] = swap;

			maxHeap(array, heapSize, largest);
		}
	}
}

class Small_Heap {

	int[] array;

	// 传入一个数组，构造一个大根堆
	public Small_Heap(int[] array) {
		if (array == null || array.length <= 1) {
			System.out.println("data unaviliable !");
		}
		this.array = array;

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(this.array, this.array.length, i);
		}
	}

	// 小根堆的排序
	void heapSort() {
		int len = this.array.length;
		int swap;
		for (int i = 0; i < array.length - 1; i++) {
			swap = array[0]; // 最大值
			array[0] = array[array.length - 1 - i];
			array[array.length - 1 - i] = swap;

			len--;
			maxHeap(array, len, 0); // 重构大根堆
		}
	}

	// heapsize 为堆的长度
	// index 为调整的开始位置
	// 从上向下调整
	void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int small = index;
		if (left < heapSize && array[left] < array[index]) {
			small = left;
		}

		if (right < heapSize && array[right] < array[small]) {
			small = right;
		}

		int swap;
		if (index != small) {
			swap = array[index];
			array[index] = array[small];
			array[small] = swap;

			maxHeap(array, heapSize, small);
		}
	}
}

// 这个使用 ArrayList 作为容器
class Small_Heap_2 {
	ArrayList<Integer> container;

	public Small_Heap_2() {
		container = new ArrayList<>();
	}

	// 插入一个元素
	public void insert(int ele) {
		container.add(0, ele);
		maxHeap(container, container.size(), 0);
	}

	// 删除一个元素（取最小值）
	public int dele_smallest() {
		if (container.size() == 0)
			return -1;

		int re = container.get(0);
		if (container.size() == 1) {
			container.clear();
			return re;
		}
		container.set(0, container.get(container.size() - 1));
		container.remove(container.size() - 1);
		maxHeap(container, container.size(), 0);
		return re;
	}

	// 判断是否为空
	public boolean empty() {
		return container.isEmpty();
	}

	// heapsize 为堆的长度
	// index 为调整的开始位置
	// 从上向下调整
	void maxHeap(ArrayList<Integer> container, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int small = index;
		if (left < heapSize && container.get(left) < container.get(index)) {
			small = left;
		}

		if (right < heapSize && container.get(right) < container.get(small)) {
			small = right;
		}

		int swap;
		if (index != small) {
			swap = container.get(index);
			container.set(index, container.get(small));
			container.set(small, swap);

			maxHeap(container, heapSize, small);
		}
	}
}
