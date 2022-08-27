import io
from flask import Flask, request, jsonify
import base64, random
from PIL import Image


app = Flask(__name__)

@app.route('/save_image', methods=['POST'])
def post():
    payload = request.get_json(force=True)
    category = payload.get("category")
    img_data = payload.get("image")
    directory = "/Users/bhavani/Desktop/sem 3/MC/assignment1/" + category + "/"
    file_name = ''.join(random.choice('ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789') for _ in range(10)) + ".png"
    file_path = directory + file_name
    img = Image.open(io.BytesIO(base64.decodebytes(bytes(img_data, "utf-8"))))
    img.save(file_path)
    return jsonify({"message": "Save successful", "error": None})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8000)
