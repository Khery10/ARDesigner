package com.example.android.ardesigner.basic.camera.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/android/ardesigner/basic/camera/interfaces/ICameraProvider;", "", "getCameraCharacteristics", "Lcom/example/android/ardesigner/basic/camera/interfaces/CameraInfo;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "app_debug"})
public abstract interface ICameraProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.android.ardesigner.basic.camera.interfaces.CameraInfo getCameraCharacteristics(@org.jetbrains.annotations.NotNull()
    android.hardware.camera2.CameraManager cameraManager);
}