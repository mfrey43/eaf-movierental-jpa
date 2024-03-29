package ch.fhnw.edu.rental.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@NamedQueries({
		@NamedQuery(name = "user.all", query = "SELECT u from User u"),
		@NamedQuery(name = "user.byLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
		@NamedQuery(name = "user.byFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
		@NamedQuery(name = "user.byEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
		@NamedQuery(name = "user.count", query="SELECT COUNT(u) FROM User u")
})
public class User {
	@Id
	@GeneratedValue
    @Column(name = "USER_ID")
	private Long id;

    @Column(name = "USER_NAME")
	private String lastName;
    @Column(name = "USER_FIRSTNAME")
	private String firstName;
    @Column(name = "USER_EMAIL")
	private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Rental> rentals;

    public User(){}

	public User(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.rentals = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public int getCharge() {
		int result = 0;
		for (Rental rental : rentals) {
			result += rental.getMovie().getPriceCategory().getCharge(rental.getRentalDays());
		}
		return result;
	}

}
