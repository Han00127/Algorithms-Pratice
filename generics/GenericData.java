package generics;

public class GenericData<E> {  // or <T>

		private E data;
		
		public GenericData(E data) {
			this.data = data;
		}
		public E getData() {return data;}
		//public void setData() {this.data = data;}
		public String toString() {
			return "Data: " + data;
		}
}
