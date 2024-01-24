import cv2

# 使用第一个USB摄像头
cap = cv2.VideoCapture(0) 

if not cap.isOpened():
    print("Cannot open camera")
    exit()

while True:
    # 从摄像头捕获一帧
    ret, frame = cap.read()
    # 如果正确读取帧，ret为True
    if not ret:
        print("Can't receive frame (stream end?). Exiting ...")
        break

    # 显示结果帧
    cv2.imshow('USB Cam', frame)
    
    # 如果按下'q'键，则退出循环
    if cv2.waitKey(10) == ord('q'):
        break

# 释放摄像头并关闭所有窗口
cap.release()
cv2.destroyAllWindows()
