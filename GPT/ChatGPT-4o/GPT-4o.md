# 

GPT-4o (“o” for “omni”) is a step towards much more natural **human-computer interaction**—it accepts as *input* any combination of **text, audio, and image** and generates any combination of text, audio, and image outputs. It can respond to audio inputs in as little as 232 milliseconds, with an average of 320 milliseconds, which is similar to [human response time(opens in a new window)](https://www.pnas.org/doi/10.1073/pnas.0903616106) in a conversation. It matches GPT-4 Turbo performance on text in English and code, with significant improvement on text in non-English languages, while also being much faster and 50% cheaper in the API. GPT-4o is especially better at vision and audio understanding compared to existing models.

<!--GPT-4o（“o”代表“omni”）是迈向更自然的**人机交互**的一步----它接受文本、音频和图像的任意组合作为输入，并生成文本、音频和图像的任意组合输出。 它可以在短至 232 毫秒的时间内响应音频输入，平均为 320 毫秒，这与人类在对话中的响应时间(opens in a new window)相似。 它在英语文本和代码上的性能与 GPT-4 Turbo 的性能相匹配，在非英语文本上的性能显着提高，同时 API 的速度也更快，成本降低了 50%。 与现有模型相比，GPT-4o 在视觉和音频理解方面尤其出色。-->

Prior to GPT-4o, you could use [Voice Mode](https://openai.com/index/chatgpt-can-now-see-hear-and-speak) to talk to ChatGPT with *latencies* of 2.8 seconds (GPT-3.5) and 5.4 seconds (GPT-4) on average. To achieve this, Voice Mode is a pipeline of **three separate models**: one simple model transcribes audio to text, GPT-3.5 or GPT-4 takes in text and outputs text, and a third simple model converts that text back to audio. This process means *that the main source of intelligence, GPT-4, loses a lot of information*—it can’t directly observe tone, multiple speakers, or background noises, and it can’t output laughter, singing, or express emotion.

<!--在 GPT-4o 之前，您可以使用语音模式与 ChatGPT 对话，平均延迟为 2.8 秒 (GPT-3.5) 和 5.4 秒 (GPT-4)。 为了实现这一目标，语音模式是由三个独立模型组成的管道：一个简单模型将音频转录为文本，GPT-3.5 或 GPT-4 接收文本并输出文本，第三个简单模型将该文本转换回音频。 这个过程意味着主要智能来源GPT-4丢失了大量信息----它无法直接观察音调、多个说话者或背景噪音，也无法输出笑声、歌唱或表达情感。-->

With GPT-4o, we trained a single new model **end-to-end** across text, vision, and audio, meaning that *all inputs and outputs are processed by the same neural network*. Because GPT-4o is our first model combining all of these modalities, we are still just scratching the surface of exploring what the model can do and its limitations.

<!--借助 GPT-4o，我们跨文本、视觉和音频端到端地训练了一个新模型，这意味着所有输入和输出都由同一神经网络处理。 由于 GPT-4o 是我们第一个结合所有这些模式的模型，因此我们仍然只是浅尝辄止地探索该模型的功能及其局限性。-->

# Model evaluations

As measured on traditional benchmarks, GPT-4o achieves GPT-4 Turbo-level performance on **text, reasoning, and coding intelligence**, while setting new high watermarks on **multilingual, audio, and vision capabilities.**

<!--根据传统基准测试，GPT-4o 在文本、推理和编码智能方面实现了 GPT-4 Turbo 级别的性能，同时在多语言、音频和视觉功能上设置了新的高水位线。具体性能描述见https://openai.com/index/hello-gpt-4o/ -->

### Language tokenization

These 20 languages were chosen as representative of the new tokenizer's compression across different language families

# Model safety and limitations

GPT-4o has safety built-in by design across modalities, through techniques such as filtering training data and refining the model’s behavior through post-training. We have also created new safety systems to provide guardrails on voice outputs.

<!--GPT-4o 通过过滤训练数据和通过训练后细化模型行为等技术，在跨模式设计中内置了安全性。 我们还创建了新的安全系统，为语音输出提供防护。-->

We’ve evaluated GPT-4o according to our [Preparedness Framework](https://openai.com/preparedness) and in line with our [voluntary commitments](https://openai.com/index/moving-ai-governance-forward/). Our evaluations of **cybersecurity, CBRN, persuasion, and model autonomy** show that GPT-4o does not score above Medium risk in any of these categories. This assessment involved running a suite of automated and human evaluations throughout the model training process. We tested both pre-safety-mitigation and post-safety-mitigation versions of the model, using custom fine-tuning and prompts, to better elicit model capabilities.

<!--我们根据我们的准备框架并按照我们的自愿承诺评估了 GPT-4o。 我们对网络安全、CBRN、说服力和模型自主性的评估表明，GPT-4o 在这些类别中的任何类别中的得分都不高于中等风险。 该评估涉及在整个模型训练过程中运行一套自动化和人工评估。 我们使用自定义微调和提示测试了模型的安全缓解前和安全缓解后版本，以更好地激发模型功能。-->

GPT-4o has also undergone extensive external red teaming with 70+ external experts in domains such as social psychology, bias and fairness, and misinformation to identify risks that are introduced or amplified by the newly added modalities. We used these learnings to build out our safety interventions in order to improve the safety of interacting with GPT-4o. We will continue to mitigate new risks as they’re discovered.

<!--GPT-4o 还与社会心理学、偏见和公平以及错误信息等领域的 70 多名外部专家进行了广泛的外部红队合作，以识别新添加的模式引入或放大的风险。 我们利用这些经验来制定安全干预措施，以提高与 GPT-4o 交互的安全性。 我们将继续降低发现的新风险。-->

We recognize that GPT-4o’s audio modalities present a variety of novel risks. Today we are publicly releasing text and image inputs and text outputs. Over the upcoming weeks and months, we’ll be working on the technical infrastructure, usability via post-training, and safety necessary to release the other modalities. For example, at launch, *audio outputs will be limited to a selection of preset voices and will abide by our existing safety policies*. We will share further details addressing the full range of GPT-4o’s modalities in the forthcoming system card.

<!--我们认识到 GPT-4o 的音频模式带来了各种新的风险。 今天，我们公开发布文本和图像输入以及文本输出。 在接下来的几周和几个月里，我们将致力于技术基础设施、培训后的可用性以及发布其他模式所需的安全性。 例如，在发布时，音频输出将仅限于选择预设的声音，并将遵守我们现有的安全政策。 我们将在即将发布的系统卡中分享有关 GPT-4o 全部模式的更多详细信息。-->

# Model availability

GPT-4o is our **latest** step in pushing the boundaries of deep learning, this time in the direction of practical usability. We spent a lot of effort over the last two years working on **efficiency improvements at every layer of the stack**. As a first fruit of this research, we’re able to make a GPT-4 level model available much more broadly. GPT-4o’s capabilities will be rolled out iteratively (with extended red team access starting today). 

<!--GPT-4o 是我们突破深度学习界限的最新举措，这次是朝着实用性的方向发展。 在过去的两年里，我们花费了大量的精力来提高堆栈每一层的效率。 作为这项研究的第一个成果，我们能够更广泛地提供 GPT-4 级别模型。 GPT-4o 的功能将迭代推出（从今天开始扩大红队访问权限）。-->

GPT-4o’s text and image capabilities are starting to roll out today in ChatGPT. We are making GPT-4o available in the free tier, and to Plus users with up to 5x higher message limits. We'll roll out a new version of Voice Mode with GPT-4o in alpha within ChatGPT Plus in the coming weeks.

<!--GPT-4o 的文本和图像功能今天开始在 ChatGPT 中推出。 我们正在免费套餐中提供 GPT-4o，并向 Plus 用户提供高达 5 倍的消息限制。 未来几周内，我们将在 ChatGPT Plus 中推出新版语音模式 GPT-4o 的 alpha 版。-->

Developers can also now access GPT-4o in the API as a text and vision model. GPT-4o is 2x faster, half the price, and has 5x higher rate limits compared to GPT-4 Turbo. We plan to launch support for GPT-4o's new audio and video capabilities to a small group of trusted partners in the API in the coming weeks.

<!--开发人员现在还可以在 API 中访问 GPT-4o 作为文本和视觉模型。 与 GPT-4 Turbo 相比，GPT-4o 速度提高 2 倍，价格降低一半，速率限制提高 5 倍。 我们计划在未来几周内在 API 中向一小群值得信赖的合作伙伴推出对 GPT-4o 新音频和视频功能的支持。-->