import cv2
import time
import datetime

# 使用第一个USB摄像头
cap = cv2.VideoCapture(0) 

if not cap.isOpened():
    print("Cannot open camera")
    exit()

# 加载人脸检测模型
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

recording = False
start_time = time.time()
frame_count = 0

while True:
    ret, frame = cap.read()
    if not ret:
        print("Can't receive frame (stream end?). Exiting ...")
        break

    frame_count += 1

    # 转换到灰度图，以便进行人脸检测
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.1, 4)

    # 在检测到的每个人脸周围画矩形框
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (255, 0, 0), 2)

    # 显示带有人脸检测的帧
    cv2.imshow('USB Cam', frame)

    # 检查是否开始/停止录制
    if cv2.waitKey(10) == ord('r'):
        recording = not recording
        if recording:
            current_time = datetime.datetime.now().strftime("%Y%m%d_%H%M%S")
            video_filename = f"/home/pi/myshare/RecordTest/recording_{current_time}.avi"
            fourcc = cv2.VideoWriter_fourcc(*'XVID')
            out = cv2.VideoWriter(video_filename, fourcc, 20.0, (640, 480))
        else:
            out.release()

    if recording:
        out.write(frame)

    # 截图功能
    if cv2.waitKey(10) == ord('s'):
        current_time = datetime.datetime.now().strftime("%Y%m%d_%H%M%S")
        image_filename = f"/home/pi/myshare/RecordTest/screenshot_{current_time}.jpg"
        cv2.imwrite(image_filename, frame)

    # 如果按下'q'键，则退出循环
    if cv2.waitKey(10) == ord('q'):
        break

cap.release()
if recording:
    out.release()
cv2.destroyAllWindows()
