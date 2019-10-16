
public class Array<E> {
	private E[] data;
	private int size;
	
	public Array(int capacity) {
		data = (E[])new Object[capacity];
	}
	
	public Array() {
		this(10);
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void add(int index, E e) {
		
		if(index < 0 || index > this.size ) {
			throw new IllegalArgumentException("index need to >=0 and <= size");
		}
		
		if(size==this.data.length) {
			this.resize(data.length * 2);
		}
		
		for(int i = this.size-1;i >= index; i--) {
			data[i+1] = data[i];
		}
		
		data[index] = e;
		size++;
	}
	
	public void addFirst(E e) {
		add(0,e);
	}
	
	public void addLast(E e) {
		add(size,e);
	}
	
	@Override
	public String toString() {
		StringBuilder  res = new StringBuilder();
		res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
		res.append("[");
		for(int i = 0; i < size; i++) {
			res.append(data[i]);
			if(i != size - 1) {
				res.append(", ");
			}
		}
		res.append("]");
		
		return res.toString();
	}
	
	public E get(int index) {
		if(index < 0 || index > size - 1) {
			throw new IllegalArgumentException("index need to >= 0 and <=size - 1");
		}
		return data[index];
	}
	
	public void set(int index, E e) {
		if(index < 0 || index > size - 1) {
			throw new IllegalArgumentException("index need to >= 0 and <=size - 1");
		}
		
		data[index] = e;
	}
	
	//�����������Ƿ���Ԫ��e
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e) ) {
				return true;
			}
			
		}
		return false;
	}
	
	//����Ԫ��e���ڵ�����,���������Ԫ��e,�򷵻�-1
	public int find(E e) {
		for(int i = 0; i <size; i++) {
			if(data[i] .equals(e) ) {
				return i;
			}
		}
		return -1;
	}
	
	//��ָ��λ�ô�ɾ��Ԫ��
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("remove failed, index is illegal");
		}
		
		
		E rev = data[index];
		for(int i = index + 1; i < size; i++) {
			data[i-1] = data[i];
		}
		size--;
		if(size == data.length/4 && data.length/2 != 0) {
			this.resize(data.length/2);
		}
		return rev;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	//ɾ��ָ����Ԫ��
	public boolean removeElement(E e) {
		int index = find(e);
		if(index != -1) {
			this.remove(index);
		}
		index = find(e);
		if(index == -1) {
			System.out.println("�������Ѿ�û�и�Ԫ��");
			return true;//ɾ���ɹ�
		}else {
			System.out.println("��������Ȼ���ڸ�Ԫ��");
			return false;//ɾ��ʧ��
		}
		
	}
	
	//���¶�������ռ�
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];
		for(int i = 0; i < this.size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
	
	
	
	
	
	

}
