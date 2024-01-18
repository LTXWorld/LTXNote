import cv2
import time
import datetime

# 使用第一个USB摄像头
cap = cv2.VideoCapture(0) 

if not cap.isOpened():
    print("Cannot open camera")
    exit()

recording = False
start_time = time.time()
frame_count = 0

while True:
    ret, frame = cap.read()
    if not ret:
        print("Can't receive frame (stream end?). Exiting ...")
        break

    frame_count += 1

    # 显示帧率
    elapsed_time = time.time() - start_time
    if elapsed_time > 0:
        fps = frame_count / elapsed_time
        cv2.putText(frame, f"FPS: {fps:.2f}", (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)

    cv2.imshow('USB Cam', frame)

    # 检查是否开始/停止录制
    if cv2.waitKey(1) == ord('r'):
        recording = not recording
        if recording:
            # 使用当前时间戳来命名视频文件
            current_time = datetime.datetime.now().strftime("%Y%m%d_%H%M%S")
            video_filename = f"/home/lutao/Documents/New/recording_{current_time}.avi"
            fourcc = cv2.VideoWriter_fourcc(*'XVID')
            out = cv2.VideoWriter(video_filename, fourcc, 20.0, (640, 480))
        else:
            out.release()

    if recording:
        out.write(frame)

    # 截图功能
    if cv2.waitKey(1) == ord('s'):
        # 使用当前时间戳来命名图像文件
        current_time = datetime.datetime.now().strftime("%Y%m%d_%H%M%S")
        image_filename = f"/home/lutao/Documents/New/screenshot_{current_time}.jpg"
        cv2.imwrite(image_filename, frame)

    # 如果按下'q'键，则退出循环
    if cv2.waitKey(1) == ord('q'):
        break

cap.release()
if recording:
    out.release()
cv2.destroyAllWindows()
