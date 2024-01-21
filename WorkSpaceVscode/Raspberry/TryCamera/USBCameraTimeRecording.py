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
frame_count = 0
face_detection_times = []  # 用于存储每次人脸检测的耗时

while True:
    ret, frame = cap.read()
    if not ret:
        print("Can't receive frame (stream end?). Exiting ...")
        break

    frame_count += 1

    # 开始计时
    start_time = time.time()

    # 转换到灰度图，并进行人脸检测
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.1, 4)

    # 停止计时并计算耗时
    detection_time = time.time() - start_time
    face_detection_times.append(detection_time)

    # 在检测到的每个人脸周围画矩形框
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (255, 0, 0), 2)

    cv2.imshow('USB Cam', frame)

    # 其余代码（录制、截图、退出）...

    if cv2.waitKey(10) == ord('q'):
        break

# 保存人脸检测耗时数据到文件
current_time = datetime.datetime.now().strftime("%Y%m%d_%H%M%S")
with open(f"/home/lutao/Documents/New/face_detection_times{current_time}.txt", "w") as file:
    for detection_time in face_detection_times:
        file.write(f"{detection_time}\n")

cap.release()
if recording:
    out.release()
cv2.destroyAllWindows()
