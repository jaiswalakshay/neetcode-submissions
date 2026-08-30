class DynamicArray {

    private int arr[] = new int[0];
    private int length=0;
    private int capacity=0;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity=capacity;
    }

    public int get(int i) {
        if(i<length  && i>=0)
            return arr[i];   
        else return -1;     
    }

    public void set(int i, int n) {
        if(i<length  && i>=0)
        {
            arr[i] = n;
        }            
    }

    public void pushback(int n) {
        if(length == capacity){
            resize();
        }
        arr[length] = n;
        length=length+1;
    }

    public int popback() {
        int temp = arr[length-1];
        length = length-1;
        return temp;
    }

    private void resize(){
        capacity = capacity * 2;
        int[] arr1= new int[capacity];
        for(int i=0;i<length;i++){
            arr1[i]=arr[i];
        }
        this.arr = arr1;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
