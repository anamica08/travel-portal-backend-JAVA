//package com.nagarro.travelportal.Service;
//
//import org.springframework.web.multipart.MultipartFile;
//
//public class FileHandlingService {
//	@PostMapping("/upload/db")
//	public ResponseEntity uploadToDB(@RequestParam("file") MultipartFile file) {
//		Document doc = new Document();
//		
//		doc.setDocName(fileName);
//		try {
//			doc.setFile(file.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		documentDao.save(doc);
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//				.path("/files/download/")
//				.path(fileName).path("/db")
//				.toUriString();
//		return ResponseEntity.ok(fileDownloadUri);
//	}
//	
//	public String addFileToDB(MultipartFile file){
//		
//		
//	}
//}
