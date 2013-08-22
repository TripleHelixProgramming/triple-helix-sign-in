package org.team2363.signin.client.fingerprint;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;

@SuppressWarnings("serial")
public class FingerprintEnrollmentForm extends FingerprintCaptureForm {
	
	private DPFPEnrollment enroller;
	private DPFPTemplate fingerprint;
	
	//private JButton enrollAcceptCancel;
	
	/*
	public FingerprintEnrollmentForm(Frame parent) {
		super(parent);

		enroller = DPFPGlobal.getEnrollmentFactory().createEnrollment();
		
		buildInterface();
	}
	
	private void buildInterface() {
		setTitle("Fingerprint Enrollment");

		enrollAcceptCancel = new JButton("Cancel");
		enrollAcceptCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
			
		});
		addToPanel(enrollAcceptCancel, BorderLayout.PAGE_END);
		
		pack();
	}
	
	@Override
	protected void start() {
		super.start();
		
		setPrompt("Using the fingerprint reader, scan your fingerprint. Scans needed: " + getEnroller().getFeaturesNeeded());
	}
	
	@Override
	protected void process(DPFPSample sample) {
		super.process(sample);
		
		// Process the sample and create a feature set for enrollment purposes
		DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
		
		// Check quality of the sample and add to enroller if good
		if (features != null) {
			try	{
				appendLog("Fingerprint feature set was created.");
				getEnroller().addFeatures(features);
				setPrompt("Using the fingerprint reader, scan your fingerprint. Scans needed: " + getEnroller().getFeaturesNeeded());
			} catch (DPFPImageQualityException e) {
				
			} finally {	
				// Check if template has been created.
				switch(getEnroller().getTemplateStatus())
				{
					case TEMPLATE_STATUS_READY:
						stop();
						setPrompt("Enrollment complete.");
						setFingerprint(getEnroller().getTemplate());
						enrollAcceptCancel.setText("Accept");
						break;
	
					case TEMPLATE_STATUS_FAILED:
						getEnroller().clear();
						stop();
						JOptionPane.showMessageDialog(FingerprintEnrollmentForm.this, "The fingerprint template is not valid. Repeat fingerprint enrollment.", "Fingerprint Enrollment", JOptionPane.ERROR_MESSAGE);
						start();
						break;
				}
			}
		}
	}
	*/

	public DPFPEnrollment getEnroller() {
		return enroller;
	}
	
	public DPFPTemplate getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(DPFPTemplate fingerprint) {
		this.fingerprint = fingerprint;
	}
	
}
