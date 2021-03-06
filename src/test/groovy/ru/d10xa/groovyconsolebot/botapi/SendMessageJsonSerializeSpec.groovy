/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.d10xa.groovyconsolebot.botapi

import com.google.gson.Gson
import spock.lang.Specification

class SendMessageJsonSerializeSpec extends Specification {

    String json

    def setup() {
        json = getClass().getClassLoader().getResource("json/sendMessage_1465736691.json").text
    }

    def 'serialize sendMessage request'() {
        given:
        SendMessageRequest expectedRequest = new SendMessageRequest(
                "chat_id": "5556660",
                "text": "8",
                "reply_to_message_id": 585
        )

        when:
        SendMessageRequest request = new Gson().fromJson(json, SendMessageRequest)

        then:
        request.chat_id == expectedRequest.chat_id
        request.reply_to_message_id == expectedRequest.reply_to_message_id
        request.text == expectedRequest.text
        request == expectedRequest
    }
}
