package exam_multi_type_parameter;

public class Product<T, M> {
	private T kind;
	private M model;
	
	public final T getKind() {
		return kind;
	}
	public final void setKind(T kind) {
		this.kind = kind;
	}
	public final M getModel() {
		return model;
	}
	public final void setModel(M model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Product [kind=" + kind.getClass().getSimpleName().toUpperCase() + ", model=" + model + "]";
	}
}


