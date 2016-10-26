package ch.fhnw.edu.rental.model;

import javax.persistence.*;

@Entity
@Table(name = "PRICECATEGORIES")
@DiscriminatorColumn(name = "PRICECATEGORY_TYPE")
@NamedQueries({
		@NamedQuery(name = "pricecategory.all", query = "SELECT pc from PriceCategory pc"),
		@NamedQuery(name="pricecategory.count", query="SELECT COUNT(pc) FROM PriceCategory pc")
})
public abstract class PriceCategory {
	@Id
	@GeneratedValue
	@Column(name = "PRICECATEGORY_ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
