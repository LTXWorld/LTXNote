import cv2
import numpy as np

cap = cv2.VideoCapture(0)
circles = np.zeros((4, 2), np.int)
counter = 0

def mousePoints(event, x, y, flags, params):
    global counter
    if event == cv2.EVENT_LBUTTONDOWN:
        print(x, y)
        circles[counter] = x, y
        counter += 1

cv2.namedWindow("origin img")
cv2.setMouseCallback("origin img", mousePoints)

while True:
    ret, frame = cap.read()
    if not ret:
        break

    if counter == 4:
        width, height = 600, 800
        pts1 = np.float32([circles[0], circles[1], circles[2], circles[3]])
        pts2 = np.float32([[0, 0], [width, 0], [0, height], [width, height]])
        matrix = cv2.getPerspectiveTransform(pts1, pts2)
        output = cv2.warpPerspective(frame, matrix, (width, height))
        cv2.imshow('output_img', output)
        cv2.imwrite("output_img.jpg", output)

    for i in range(0, 4):
        cv2.circle(frame, (circles[i][0], circles[i][1]), 3, (255, 0, 0), cv2.FILLED)
    
    cv2.imshow("origin img", frame)

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
