package innotech.com.sv.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="SendMessages")
public class SendMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Mensaje message;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date date_time_Send;
	
	@NotBlank(message = "No se puede dejar vacio la confirmacion Twilio")
	private String TwilioConfirmation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mensaje getMessage() {
		return message;
	}

	public void setMessage(Mensaje message) {
		this.message = message;
	}

	public Date getDate_time_Send() {
		return date_time_Send;
	}

	public void setDate_time_Send(Date date_time_Send) {
		this.date_time_Send = date_time_Send;
	}

	public String getTwilioConfirmation() {
		return TwilioConfirmation;
	}

	public void setTwilioConfirmation(String twilioConfirmation) {
		TwilioConfirmation = twilioConfirmation;
	}
	
	
	
	
	
}
