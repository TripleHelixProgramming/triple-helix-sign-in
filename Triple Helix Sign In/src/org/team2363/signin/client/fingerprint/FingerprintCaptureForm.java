package org.team2363.signin.client.fingerprint;


import java.awt.Image;

import com.digitalpersona.onetouch.DPFPCaptureFeedback;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPImageQualityAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPImageQualityEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.processing.DPFPSampleConversion;

@SuppressWarnings("serial")
public class FingerprintCaptureForm {

	//public static final int SCALING_ALGORITHM = Image.SCALE_SMOOTH;
	public static final int IMAGE_WIDTH = 120;
	public static final int IMAGE_HEIGHT = 140;
	
	private DPFPCapture capturer;
	
	/*
	private JPanel capturePanel;
	private JLabel capturePrompt;
	private JLabel captureImage;
	private JScrollPane captureLogPane;
	private JTextArea captureLog;
	
	public FingerprintCaptureForm(Frame parent) {
		super(parent, true);
		
		buildInterface();
		
		capturer = DPFPGlobal.getCaptureFactory().createCapture();
	}
	
	private void buildInterface() {
		setTitle("Fingerprint Entry");
		
		capturePanel = new JPanel();
		capturePanel.setLayout(new BorderLayout(5, 5));
		capturePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Prompt
		capturePrompt = new JLabel();
		capturePrompt.setHorizontalAlignment(SwingConstants.CENTER);

		// Image
		captureImage = new JLabel();
		captureImage.setPreferredSize(new Dimension(FingerprintCaptureForm.IMAGE_WIDTH, FingerprintCaptureForm.IMAGE_HEIGHT));
		captureImage.setBorder(BorderFactory.createEtchedBorder());
		captureImage.setBackground(Color.WHITE);
		captureImage.setOpaque(true);
		
		// Log
		captureLog = new JTextArea("Status Log:\n\n");
		captureLog.setColumns(45);
		captureLog.setMargin(new Insets(5, 5, 5, 5));
		captureLog.setEditable(false);
		captureLogPane = new JScrollPane(captureLog);
		captureLogPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		captureLogPane.setHorizontalScrollBar(null);
		
		addToPanel(capturePrompt, BorderLayout.PAGE_START);
		addToPanel(captureImage, BorderLayout.WEST);
		addToPanel(captureLogPane, BorderLayout.CENTER);
		
		addComponentListener(new ComponentAdapter() {
			
			@Override 
			public void componentShown(ComponentEvent e) {
				init();
				start();
			}
			
			@Override 
			public void componentHidden(ComponentEvent e) {
				stop();
			}
			
		});
		
		add(capturePanel);
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	protected void init() {
		getCapturer().addDataListener(new DPFPDataAdapter() {
			
			@Override 
			public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						appendLog("Fingerprint sample was captured.");
						process(e.getSample());
					}
					
				});
			}
			
		});
		getCapturer().addReaderStatusListener(new DPFPReaderStatusAdapter() {
			
			@Override 
			public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						appendLog("Fingerprint reader was connected.");
					}
					
				});
			}
			
			@Override 
			public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	
					
					public void run() {
						appendLog("Fingerprint reader was disconnected.");
					}
					
				});
			}
			
		});
		getCapturer().addSensorListener(new DPFPSensorAdapter() {
			
			@Override 
			public void fingerTouched(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						appendLog("Fingerprint reader was touched.");
					}
					
				});
			}
			
			@Override 
			public void fingerGone(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						appendLog("Finger was removed from the fingerprint reader.");
					}
					
				});
			}
			
		});
		getCapturer().addImageQualityListener(new DPFPImageQualityAdapter() {
			
			@Override 
			public void onImageQuality(final DPFPImageQualityEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						if(e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD)) {
							appendLog("Quality of the fingerprint sample is good.");
						} else {
							appendLog("Quality of the fingerprint sample is poor.");
						}
					}
					
				});
			}
			
		});
	}
	
	protected void start() {
		try {
			getCapturer().startCapture();
		} catch(RuntimeException e) {
			NotificationDialog.showLibraryLoadError(FingerprintCaptureForm.this, e);
			System.exit(1);
		}
	}
	*/

	protected void stop() {
		getCapturer().stopCapture();
	}
	
	/*
	protected void process(DPFPSample sample) {
		drawImage(convertSampleToBitmap(sample));
	}
	
	public void drawImage(Image icon) {
		captureImage.setIcon(new ImageIcon(icon.getScaledInstance(captureImage.getWidth(), captureImage.getHeight(), FingerprintCaptureForm.SCALING_ALGORITHM)));
	}
	
	protected Image convertSampleToBitmap(DPFPSample sample) {
		return DPFPGlobal.getSampleConversionFactory().createImage(sample, DPFPSampleConversion.STANDARD_RESOLUTION, false);
	}
	*/
	
	protected DPFPFeatureSet extractFeatures(DPFPSample sample, DPFPDataPurpose purpose) {
		DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
		try {
			return extractor.createFeatureSet(sample, purpose);
		} catch (DPFPImageQualityException e) {
			return null;
		}
	}
	
	public DPFPCapture getCapturer() {
		return capturer;
	}
	
	/*
	public void addToPanel(Component component, Object constraints) {
		capturePanel.add(component, constraints);
	}
	
	public void removeFromPanel(Component component) {
		capturePanel.remove(component);
	}
	
	public String getPrompt() {
		return capturePrompt.getText();
	}

	public void setPrompt(String text) {
		capturePrompt.setText(text);
	}
	
	public String getLog() {
		return captureLog.getText();
	}
	
	public void appendLog(String text) {
		captureLog.append(text + "\n");
		captureLog.setCaretPosition(captureLog.getText().length());
	}
	
	*/
	
}
