package com.example.crm.entity;

import java.io.Serializable;

import com.example.crm.validation.TcKimlikNo;

// Alt + Shift + S
@SuppressWarnings("serial")
public class Identity implements Serializable {
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer id;
	@TcKimlikNo(message = "This is not a valid identity no!")
	private String no;

	public Identity() {
	}

	public Identity(String no) {
		this.no = no;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identity other = (Identity) obj;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Identity [no=" + no + "]";
	}

}
