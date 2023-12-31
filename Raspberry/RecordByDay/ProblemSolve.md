# Problems

## Changed IP Address

When I open the Raspberry after two weeks(lol),I can't connect it from the former IP.So I realised that the IP of Raspberry made a  change.

**Firstly,why?**

- Because of the DHCP
- This protocol will assign IP address automatically for the device on the internet.So it is not permanently assigned to this device.When a device is disconnected for a period of time,the previous IP address may be reclaimed and assigned to other devices on the network.
- Specifically,it's called 'lease period',after the lease expires,the DHCP server may assign a new address.

**Then,we should solve this problem.How?**

- We can set a static IP address for Raspberry.Let's do it.
- Emmmm,I try to set a static IP address for Raspberry,but it **didn't work**.I search for the internet,it maybe casued by several reasons:
  - The main reason is I am in the **Campus Network System**,it's a  huge network system.So if I set a static IP address for my device,but this address falls within the dynamic address allocation range of the DHCP server,the DHCP may assign the same address to another device,**causing a conflict.**
  - Maybe I should ask the IT section to give me a static IP address :)
- Sorry to hear that.

So in the end,we have to confim the IP address for this device when we open it everytime(Rigorously,you'd better open it everyday,that means DHCP may not change your IP lol)

But I should review the whole procedure about how to try it.

- If you have a screen,you can make it by your view interface.
- First,you should know your current IP address:`hostname -I`
- Secondly,you should get your router IP:`ip route`,the result is behind the word 'default'
- Last address is your DNS IP:usally we use the `8.8.8.8`(Google's address)