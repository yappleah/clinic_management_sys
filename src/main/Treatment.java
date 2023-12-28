package src.main;

import java.time.LocalDate;

/**
 * class Treatment
 * 
 * @version 1.00
 * @since 2023-12-18
 * @author Team 6
 */

public class Treatment {
    private String treatmentId, doctorId, patientId;
    private String medication, description;
    private LocalDate issueDate, startDate, endDate;

    /**
     * constructor with parameter
     * @param medication String
     * @param description String
     * @param startDate LocalDate
     * @param endDate LocalDate
     * @throws Exception when a string is blank, or when start date is a past date, or when end date is before start date
     */
    public Treatment(String medication, String description, LocalDate startDate, LocalDate endDate) throws Exception {
        setMedication(medication);
        setDescription(description);
        setIssueDate();
        setStartDate(startDate);
        setEndDate(endDate);
    } // end constructor with parameter

    // setters
    /**
     * sets the medication of the treatment
     * @param medication String
     * @throws Exception when the string is blank
     */
    public void setMedication(String medication) throws Exception {
        if (medication.isBlank()) {
            throw new Exception("Invalid input: medication cannot be blank");
        }
        this.medication = medication;
    } // end method setMedication

    /**
     * sets the description of the treatment
     * @param description String
     * @throws Exception when the string is blank
     */
    public void setDescription(String description) throws Exception {
        if (description.isBlank()) {
            throw new Exception("Invalid input: description cannot be blank");
        }
        this.description = description;
    } // end method setDescription

    /**
     * sets the issue date to be today
     */
    private void setIssueDate() {
        this.issueDate = LocalDate.now();
    } // end method setIssueDate

    /**
     * sets the start date of the treatment
     * @param startDate LocalDate
     * @throws Exception when the date is a past date
     */
    public void setStartDate(LocalDate startDate) throws Exception {
        if (startDate.isBefore(issueDate)) {
            throw new Exception("Invalid input: start date must be a future date.");
        }
        this.startDate = startDate;
    } // end method setStartDate

    /**
     * sets the end date of the treatment
     * @param endDate LocalDate
     * @throws Exception when the date is before start date
     */
    public void setEndDate(LocalDate endDate) throws Exception {
        if (endDate.isBefore(startDate)) {
            throw new Exception("Invalid input: end date must be after the start date.");
        }
        this.endDate = endDate;
    } // end method setEndDate

    // getters
    /**
     * gets the medication of the treatment
     * @return String
     */
    public String getMedication() {
        return this.medication;
    }

    /**
     * gets the description of the treatment
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * gets the issue date of the treatment
     * @return LocalDate
     */
    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    /**
     * gets the start date of the treatment
     * @return LocalDate
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * gets the end date of the treatment
     * @return LocalDate
     */
    public LocalDate getEndDate() {
        return this.endDate;
    }

    // return string representation of treatment object 
    @Override
    public String toString() {
        return String.format("Medication: %s %nDescription: %s %nIssue Date: %s %nStart Date: %s %nEnd date: %s %n",
                                getMedication(), getDescription(), getIssueDate(), getStartDate(), getEndDate());
    } // end method toString
}
