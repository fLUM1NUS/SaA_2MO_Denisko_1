public class MySort<T extends Comparable<T>> {

    private void swap(T[] items, int left, int right)
    {
        if (left != right)
        {
            T temp = items[left];
            items[left] = items[right];
            items[right] = temp;
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private void qSortV(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qSortV(arr, low, pivot - 1);
            qSortV(arr, pivot + 1, high);
        }
    }

    public  void qSort(T[] arr) {
        int low = 0;
        int high = arr.length - 1;
        qSortV(arr, low, high);
    }

    public void bSort(T[] arr) {
        boolean f;
        do {
            f = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    f = true;
                }
            }
        } while (f);
    }

}
