package org.team2363.signin.client.fingerprint;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;

@SuppressWarnings("serial")
public class FingerprintVerificationForm extends FingerprintCaptureForm {
	
	private DPFPVerification verificator;
	private DPFPTemplate fingerprint;
	
	//private JButton verifyClose;
	
	private boolean verified;
	
	/*
	public FingerprintVerificationForm(Frame parent, DPFPTemplate fingerprint) {
		super(parent);
		
		setFingerprint(fingerprint);
		
		verificator = DPFPGlobal.getVerificationFactory().createVerification();
		
		verified = false;
		
		buildInterface();
	}
	
	private void buildInterface() {
		setTitle("Fingerprint Verification");

		verifyClose = new JButton("Close");
		verifyClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
			
		});
		addToPanel(verifyClose, BorderLayout.PAGE_END);
		
		pack();
	}
	
	@Override
	protected void start() {
		super.start();
		
		setPrompt("Using the fingerprint reader, scan your fingerprint.");
	}
	
	@Override
	protected void process(DPFPSample sample) {
		super.process(sample);

		// Process the sample and create a feature set for the enrollment purpose.
		DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

		// Check quality of the sample and start verification if it's good
		if (features != null) {
			// Compare the feature set with our template
			DPFPVerificationResult result = getVerificator().verify(features, getFingerprint());
			if (result.isVerified()) {
				setVerified(true);
				appendLog(String.format("Fingerprint was VERIFIED. False Accept Rate = %1$s", result.getFalseAcceptRate()));
			} else {
				appendLog(String.format("Fingerprint was NOT VERIFIED. False Accept Rate = %1$s", result.getFalseAcceptRate()));
			}
		}
	}
	*/

	public DPFPVerification getVerificator() {
		return verificator;
	}
	
	public DPFPTemplate getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(DPFPTemplate fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	public boolean isVerified() {
		return verified;
	}
	
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}
