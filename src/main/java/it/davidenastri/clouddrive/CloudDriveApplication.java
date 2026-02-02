package it.davidenastri.clouddrive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.GraphicsEnvironment;

@SpringBootApplication
@MapperScan("it.davidenastri.clouddrive.mapper") // Quét các Mapper
public class CloudDriveApplication {


	public static void main(String[] args) {
		// Khởi động Spring Boot trong một luồng riêng
		new Thread(() -> SpringApplication.run(CloudDriveApplication.class, args)).start();

		SwingUtilities.invokeLater(() -> {
			LoginPage mainFrame = new LoginPage();
			mainFrame.setVisible(true);
		});
	}

}
