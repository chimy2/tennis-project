package com.test.java;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;

public class Test {
    public static void main(String[] args) {
        // Eclipse Display 가져오기
        Display display = Display.getDefault();
        
        // 폰트 데이터 생성
        FontData fontData = new FontData("Arial", 12, SWT.NORMAL);
        
        // FontDescriptor를 사용하여 Font 설정
        FontDescriptor fontDescriptor = FontDescriptor.createFrom(fontData);
        System.out.println(fontDescriptor);
        // JFaceResources를 사용하여 기본 폰트를 변경
        JFaceResources.getFontRegistry().put(JFaceResources.DEFAULT_FONT, fontDescriptor);
        
        // Display에 변경된 폰트 적용
        display.asyncExec(() -> {
            display.update();
        });
        
        // 설정 완료 메시지 출력
        System.out.println("폰트 설정이 변경되었습니다.");
    }
}
