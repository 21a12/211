package hospital;

public class Patient {
	private String name;
	private String symptom;
	private String medicine;

	Patient(String n, String sym) {
		name = n;
		symptom = sym;
	}

	public String getSymptom() {
		return symptom;
	}

	public String getName() {
		return name;
	}

	public void prescribed(String med) {
		medicine = med;
	}

	public String getMedicine() {
		return medicine;
	}

	public void printPrescripty() {
		String selectWord = Convertor.selectBySupport(medicine, "을", "를");
		System.out.println(name + "님, " + symptom + "증상이 있으셔서 " + medicine + selectWord + " 처방해드리겠습니다.");
	}

}
